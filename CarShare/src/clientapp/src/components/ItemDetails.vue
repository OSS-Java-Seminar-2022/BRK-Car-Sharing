<template>
  <div class="text-center d-flex align-center">
    <v-dialog v-model="currentItemSet" class="w-25">
      <v-card >
        <v-card-text>
          <v-col
            v-for="(value, name) in currentItemStore.currentItem"
            :key="name"
          >
            <v-text-field
              v-if="isSingleLine(String(value))"
              :model-value="String(value)"
              variant="outlined"
              :label="name"
              readonly
            />

            <v-textarea
              v-else
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
            block
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
      return this.currentItemStore.currentItem.id !== undefined;
    },
  },
  methods: {
    isSingleLine(text) {
      return text.indexOf("\n") === -1;
    },
  },
};
</script>
