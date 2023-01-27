<template>
  <v-card title="Vehicles" variant="tonal">
    <v-table fixed-header height="300px">
      <thead>
        <tr>
          <th class="text-left"></th>
          <th class="text-left">Make</th>
          <th class="text-left">Model</th>
          <th class="text-left">Status</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in vehicleList" :key="item.name">
          <td>
            <v-progress-circular
              v-if="currentItemStore.loading"
              indeterminate
            ></v-progress-circular>
            <v-icon
              v-else
              icon="mdi-car-info"
              @click="openTicketDetails(item)"
            />
          </td>
          <td>{{ item.make }}</td>
          <td>{{ item.model }}</td>
          <td>{{ item.status }}</td>
        </tr>
      </tbody>
    </v-table>
    <v-pagination v-model="page" :length="length" @update:modelValue="loadVehicles"></v-pagination>
  </v-card>
</template>
<script>
import { useItemStore } from "@/stores/itemStore.js";
import { mapStores } from "pinia";

export default {
  name: "VehiclesList",
  data() {
    return {
      vehicleList: [],
      loading: false,
      page:1,
      length:0,
    };
  },
  async created() {
    this.loadVehicles()
  },
  computed: {
    ...mapStores(useItemStore),
  },
  methods: {
    openTicketDetails(item) {
      this.currentItemStore.setLoading(true);
      this.currentItemStore.setCurrentItem(item);
    },
    async loadVehicles(){
      this.loading = true;
      const { data } = await this.$http.get(
          `/api/vehicle?page=${this.page-1}&size=10`
      );
      this.vehicleList = data.content;
      this.length = data.totalPages
      this.loading = false;
    }
  },
};
</script>

