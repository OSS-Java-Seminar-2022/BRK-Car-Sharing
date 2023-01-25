import { createApp } from "vue";
import "@mdi/font/css/materialdesignicons.css";
import axios from "axios";

// Vuetify
import "vuetify/styles";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";
import LoginPage from "@/pages/LoginPage.vue";

const vuetify = createVuetify({
  components,
  directives,
});

// let authResp = await axios.get('/api/auth/current-user')
//
// if(authResp.data){
//   window.location.assign("/login/")
// }

const app = createApp(LoginPage);
app.config.globalProperties.$http = axios;
app.config.globalProperties.$window = window;
app.use(vuetify);

app.mount("#login");
