<template>
  <div class="text-center d-flex align-center">
    <v-dialog v-model="currentItemSet" class="w-50">
      <v-card>
        <v-card-text>
          <v-col
            v-for="(value, name) in currentItemStore.currentItem"
            :key="name"
          >
            <v-text-field
              v-if="isSingleLine(String(value)) && name !== 'id'"
              :model-value="String(value)"
              variant="outlined"
              :label="name"
              readonly
            />

            <v-textarea
              v-else-if="name !== 'id'"
              variant="outlined"
              :model-value="value"
              :label="name"
              readonly
            />
          </v-col>
        </v-card-text>
        <v-card-actions>
          <v-btn
            color="primary"
            @click="orderCleaning"
            v-if="currentItemStore.currentItem.status !=='Cleaning' && currentItemStore.currentItem.status ==='Available'"
            >Request cleaning</v-btn
          >
          <v-btn
            color="primary"
            @click="orderService"
            v-if="currentItemStore.currentItem.status !=='In service' && currentItemStore.currentItem.status ==='Available'"
            >Request service</v-btn
          >
          <v-btn
              color="primary"
              @click="retrieveVehicle"
              v-if="currentItemStore.currentItem.status !=='Available' "
          >Retrieve vehicle</v-btn
          >
          <v-btn
            color="primary"
            @click="currentItemStore.clearCurrentItem()"
            >Close</v-btn
          >
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import { useItemStore } from "@/stores/itemStore.js";
import { mapStores } from "pinia";
export default {
  updated() {
    this.currentItemStore.setLoading(false);
  },
  computed: {
    ...mapStores(useItemStore),
    currentItemSet: function () {
      return (
          (this.currentItemStore.currentItem.id !== undefined &&
        this.currentItemStore.currentItem.make !== undefined)
      );
    },
  },
  methods: {
    isSingleLine(text) {
      return text.indexOf("\n") === -1;
    },
    async orderCleaning(){
      let vehicle = this.currentItemStore.currentItem
      vehicle.status = "Cleaning"
      this.currentItemStore.setCurrentItem(vehicle)
      await this.$http.patch(`/api/vehicle/update`,vehicle)
    },
    async orderService(){
      let vehicle = this.currentItemStore.currentItem
      vehicle.status = "In service"
      this.currentItemStore.setCurrentItem(vehicle)
      await this.$http.patch(`/api/vehicle/update`,vehicle)
    },
    async retrieveVehicle(){
      let vehicle = this.currentItemStore.currentItem
      vehicle.status = "Available"
      this.currentItemStore.setCurrentItem(vehicle)
      await this.$http.patch(`/api/vehicle/update`,vehicle)
    }
  },
};
</script>
