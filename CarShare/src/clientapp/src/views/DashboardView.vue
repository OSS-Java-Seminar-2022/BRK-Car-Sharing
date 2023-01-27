<template>
  <v-container>
    <v-row>
      <v-col>
        <TicketList />
      </v-col>
      <v-col>
        <VehiclesList />
      </v-col>
    </v-row>
    <TicketDetails />
    <VehicleDetails />
  </v-container>
</template>

<script>
import TicketList from "@/components/TicketList.vue";
import VehiclesList from "@/components/VehiclesList.vue";
import TicketDetails from "@/components/TicketDetails.vue";
import VehicleDetails from "@/components/VehicleDetails.vue";
export default {
  name: "DashboardView",
  components: { TicketList, VehiclesList, TicketDetails, VehicleDetails },
  data() {
    return {
      ticketList: [],
      vehiclesList: [],
    };
  },
  async created() {
  },
};
</script>
