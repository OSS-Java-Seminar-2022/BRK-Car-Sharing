import { defineStore } from "pinia";

export const useItemStore = defineStore("currentItem",  {
  state:()=>({
    currentItem: {},
    loading:false
  }),
  actions:{
    setCurrentItem(item) {
      this.currentItem = item;
    },
    setLoading(loading){
      this.loading = loading;
    },
    clearCurrentItem(){
      this.currentItem = {}
    }
  }
});
