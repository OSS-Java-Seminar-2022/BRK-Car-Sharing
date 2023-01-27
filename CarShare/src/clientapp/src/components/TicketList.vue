<template>
  <v-card title="Tickets" variant="tonal">
    <v-table fixed-header height="300px">
      <thead>
        <tr>
          <th class="text-left"></th>
          <th class="text-left">Title</th>
          <th class="text-left">Status</th>
          <th class="text-left">Closed</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in ticketList" :key="item.name">
          <td>
            <v-progress-circular
              v-if="currentItemStore.loading"
              indeterminate
            ></v-progress-circular>
            <v-icon
              v-else
              icon="mdi-file-document"
              @click="openTicketDetails(item)"
            />
          </td>
          <td>{{ item.title }}</td>
          <td>{{ item.status }}</td>
          <td>{{ item.isClosed }}</td>
        </tr>
      </tbody>
    </v-table>
    <v-pagination v-model="page" :length="length" @update:modelValue="loadVehicles"></v-pagination>
  </v-card>
</template>
<script>
import {useItemStore} from "@/stores/itemStore.js";
import {mapStores} from "pinia";

export default {
  name: "TicketList",
  data() {
    return {
      ticketList: [],
      loading:false,
      page:1,
      length:0,
    };
  },
  async created() {
    this.loadTickets()
  },
  computed:{
    ...mapStores(useItemStore)
  },
  methods:{
    openTicketDetails(item) {
      this.currentItemStore.setLoading(true);
      this.currentItemStore.setCurrentItem(item)
    },
    async loadTickets(){
      this.loading = true
      const { data } = await this.$http.get(
          `/api/supportticket/all?page=${this.page}&size=10`
      );
      this.ticketList = data.content;
      this.length = data.totalPages
      this.loading = false
    }
  }
};
</script>
