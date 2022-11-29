import { defineStore } from "pinia";

export const useItemStore = defineStore("currentItem",  {
  state:()=>({
    currentItem: {}
  }),
  actions:{
    setCurrentItem(item) {
      this.currentItem = item;
    },
    clearCurrentItem(){
      this.currentItem = {}
    }
  }
});
