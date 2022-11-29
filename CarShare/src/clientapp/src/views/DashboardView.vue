<template>
  <v-container>
    <v-row>
      <v-col>
        <TicketList/>
      </v-col>
      <v-col>
        <VehiclesList/>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import TicketList from "@/components/TicketList.vue";
import VehiclesList from "@/components/VehiclesList.vue";

export default {
  name: "DashboardView",
  components: {TicketList, VehiclesList},
  data() {
    return {
      ticketList: [],
      vehiclesList: [],
    };
  },
  async created() {
    const ticketListResponse = await this.$http.get(
      "http://localhost:8989/api/supportTicket/getAll"
    );
    this.ticketList = ticketListResponse.data;

    const vehiclesListResponse = await this.$http.get(
        "http://localhost:8989/api/vehicle/getAll"
    );
    this.vehiclesList = vehiclesListResponse.data;
  },
};
</script>
