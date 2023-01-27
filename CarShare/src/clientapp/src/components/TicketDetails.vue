<template>
  <div class="text-center d-flex align-center">
    <v-dialog v-model="currentItemSet" class="w-25">
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
            @click="closeTicket"
            v-if="
              currentItemStore.currentItem.status !== 'Cleaning' &&
              currentItemStore.currentItem.status === 'Available'
            "
            >Close ticket</v-btn
          >
          <v-btn color="primary" @click="currentItemStore.clearCurrentItem()"
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
        this.currentItemStore.currentItem.id !== undefined &&
        this.currentItemStore.currentItem.title
      );
    },
  },
  methods: {
    isSingleLine(text) {
      return text.indexOf("\n") === -1;
    },
    async closeTicket(){
      let ticket = this.currentItemStore.currentItem
      ticket.isClosed = true
      this.currentItemStore.setCurrentItem(ticket)
      await this.$http.patch(`/api/supportticket/update`,ticket)
    },
  },
};
</script>
