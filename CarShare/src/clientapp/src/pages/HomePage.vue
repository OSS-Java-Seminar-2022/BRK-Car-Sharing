<template>
  <v-app :theme="theme">
    <v-app-bar>
      <v-app-bar-title>BRK CarShare</v-app-bar-title>
      <template v-slot:append>
        <UserMenu/>
        <v-btn
          :ripple="false"
          variant="plain"
          @click="onClick"
          :icon="theme === 'light' ? 'mdi-weather-sunny' : 'mdi-weather-night'"
        ></v-btn>
      </template>
    </v-app-bar>

    <v-main class="d-flex">
      <v-container fluid class="d-flex flex-column align-center">
        <div id="map" class="w-100 h-100 rounded-lg d-flex align-center">
          <v-card
            elevation="10"
            color="white"
            class="rounded h-50 ml-16 hidden-md-and-down"
            min-width="480px"
            style="z-index: 10"
          >
            <v-card-title class="my-8 text-h4">Catch a ride</v-card-title>
            <v-text-field
              label="Your location"
              variant="outlined"
              :readonly="true"
              class="mt-4 mx-4"
              :model-value="address"
            ></v-text-field>
          </v-card>
        </div>
        <v-card class="flat w-100 h-75 hidden-lg-and-up">
          <v-card-title class="mt-5 text-">Catch a ride</v-card-title>
        </v-card>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import {ref} from "vue";
import mapboxgl from "mapbox-gl/dist/mapbox-gl.js";
import constants from "@/constants.js";
import UserMenu from "@/components/UserMenu.vue";

export default {
  components: {UserMenu},
  data() {
    return {
      theme: ref("dark"),
      address: null,
      vehiclesList:[]
    };
  },
  async mounted() {
    mapboxgl.accessToken = constants.accessToken;
    var map = new mapboxgl.Map({
      container: "map",
      style: constants.mapStyle,
      center: [16.4435, 43.5147],
      zoom: 13,
    });
    map.addControl(new mapboxgl.NavigationControl());
    map.addControl(
      new mapboxgl.GeolocateControl({
        positionOptions: {
          enableHighAccuracy: true,
        },
        trackUserLocation: true,
        showUserHeading: true,
      })
    );
    this.getCurrentPosition();

    let resp = await this.$http.get('/api/vehicle/all')
    this.vehiclesList = resp.data
  },
  methods: {
    onClick() {
      this.theme = this.theme === "light" ? "dark" : "light";
    },
    getCurrentPosition: function () {
      navigator.geolocation.getCurrentPosition(async (location) => {
        console.log(location.coords)
        let response = await this.$http.get(
          `https://api.mapbox.com/geocoding/v5/mapbox.places/${location.coords.longitude},${location.coords.latitude}.json?access_token=${constants.accessToken}&country=hr`
        );
        this.address = response.data.features[0].place_name;
        console.log(this.address);
      });
    },
  },
};
</script>
