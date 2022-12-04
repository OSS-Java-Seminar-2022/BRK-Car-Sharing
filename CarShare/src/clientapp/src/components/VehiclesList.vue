<template>
  <v-card title="Vehicles" variant="tonal">
    <v-table fixed-header height="300px">
      <thead>
      <tr>
        <th class="text-left">Make</th>
        <th class="text-left">Model</th>
        <th class="text-left">Status</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in vehicleList" :key="item.name">
        <td>{{ item.make }}</td>
        <td>{{ item.model }}</td>
        <td>{{ item.status }}</td>
      </tr>
      </tbody>
    </v-table>
  </v-card>
</template>
<script>
export default {
  name: 'VehiclesList',
  data(){
    return{
      vehicleList:[],
    }
  },
  async created() {
    const {data} = await this.$http.get("http://localhost:8989/api/vehicle/getAll");
    this.vehicleList = data;
  }
}
</script>