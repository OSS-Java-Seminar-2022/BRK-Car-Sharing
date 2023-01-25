import { createApp } from "vue";
import { createPinia } from "pinia";
import '@mdi/font/css/materialdesignicons.css'
import axios from "axios";

// Vuetify
import "vuetify/styles";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";
import HomePage from "@/pages/HomePage.vue";

const vuetify = createVuetify({
  components,
  directives,
});

axios.get('api/auth/current-user').then((authResp)=>{
  if(!authResp.data){
    window.location.assign("/login/")
  }
})



const app = createApp(HomePage);
app.config.globalProperties.$http = axios;
app.config.globalProperties.$window = window;
app.use(createPinia());
app.use(vuetify);

app.mount("#home");
