<template>
  <v-app :theme="theme">
    <v-navigation-drawer permanent rail expand-on-hover>
      <v-list>
        <v-list-item
          prepend-avatar="https://randomuser.me/api/portraits/women/85.jpg"
          title="Sandra Adams"
          subtitle="sandra_a88@gmailcom"
          ><template v-slot:append>
            <v-btn
              class="ml-5"
              :ripple="false"
              variant="plain"
              @click="onClick"
              :icon="
                theme === 'light' ? 'mdi-weather-sunny' : 'mdi-weather-night'
              "
            ></v-btn>
          </template>
        </v-list-item>
      </v-list>

      <v-divider></v-divider>
      <v-list density="compact" nav @click:select="changeView">
        <v-list-item
          prepend-icon="mdi-view-dashboard"
          title="Dashboard"
          value="DashboardView"
        ></v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <component :is="selectedView" />
    </v-main>
  </v-app>
</template>

<script>
import { ref } from "vue";
import DashboardView from "@/views/DashboardView.vue";
export default {
  data() {
    return {
      theme: ref("dark"),
      selectedView: "DashboardView",
    };
  },
  components: {
    DashboardView,
  },
  methods: {
    onClick() {
      this.theme = this.theme === "light" ? "dark" : "light";
    },
    changeView(event) {
      console.log(event);
      this.selectedView = event.id;
    },
  },
};
</script>
