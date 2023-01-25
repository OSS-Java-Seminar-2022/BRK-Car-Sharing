<template>
  <v-container class="h-screen d-flex justify-center align-center">
    <v-form v-model="valid" class="h-50 w-25" ref="form">
      <v-card
        class="d-flex flex-column justify-space-evenly align-center h-100"
        elevation="10"
      >
        <div class="text-h2">Login</div>
        <v-container class="w-75">
          <v-col>
            <v-row class="mb-5">
              <v-text-field
                v-model="username"
                :rules="nameRules"
                :counter="10"
                label="Username"
                required
                variant="outlined"
              ></v-text-field>
            </v-row>
            <v-row class="mb-5">
              <v-text-field
                v-model="password"
                :append-inner-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
                :rules="passRules"
                :type="show ? 'text' : 'password'"
                label="Password"
                hint="At least 8 characters"
                @click:append-inner="show = !show"
                required
                variant="outlined"
              ></v-text-field>
            </v-row>
          </v-col>
          <v-row>
            <v-col align="center">
              <v-btn color="primary" @click="submit" type="button"
                >Sign-in</v-btn
              >
            </v-col>
            <v-col align="center">
              <v-btn color="grey" @click="register()">Register</v-btn>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
    </v-form>
  </v-container>
</template>

<script>
export default {
  name: "LoginPage",
  data: () => ({
    show: false,
    valid: false,
    username: "",
    password: "",
    nameRules: [
      (v) => !!v || "Name is required",
      (v) => v.length <= 10 || "Name must be less than 10 characters",
    ],
    passRules: [
      (v) => !!v || "Password is required",
      (v) => v.length >= 8 || "Password must be longer than 8 characters",
    ],
  }),
  methods: {
    async validate() {
      const { valid } = await this.$refs.form.validate();
      return valid;
    },
    async submit() {
      let valid = await this.validate();
      if (valid) {
        this.$http
          .post("/api/auth/signin", {
            username: this.username,
            password: this.password,
          })
          .then((resp) => {
            if (resp.status === 200) {
              this.$window.location.assign("/");
            }
          });
      }
    },
    async register() {
      let valid = await this.validate();
      if (valid) {
        this.$http
            .post("/api/auth/signup", {
              username: this.username,
              password: this.password,
              email:"asd@asd"
            })
            .then((resp) => {
              if (resp.status === 200) {
                this.$window.location.assign("/");
              }
            });
      }
    },
  },
};
</script>
