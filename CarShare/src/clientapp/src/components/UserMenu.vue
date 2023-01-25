<template>
  <v-menu min-width="200px" rounded>
    <template v-slot:activator="{ props }">
      <v-btn icon v-bind="props">
        <v-avatar
            size="small"
            image="https://randomuser.me/api/portraits/men/86.jpg"
        >
        </v-avatar>
      </v-btn>
    </template>
    <v-card>
      <v-card-text>
        <div class="mx-auto d-flex flex-row align-center">
          <v-avatar
              class="mr-2"
              image="https://randomuser.me/api/portraits/men/86.jpg"
              size="x-large"
          >
          </v-avatar>
          <div>
            <!--                  <h3>{{ user.name.first + " " + user.name.last }}</h3>-->
            <h3>Bruno Bule</h3>
            <p class="text-caption mt-1">
              <!--                    {{ user.email }}-->
              brunobule1969@gmail.com
            </p>
          </div>
        </div>
        <v-list density="compact">
          <v-divider></v-divider>
          <v-list-item class="pa-0"
          >
            <v-btn variant="text" class="w-100">
              Edit Account
            </v-btn
            >
          </v-list-item
          >
          <v-divider></v-divider>
          <v-list-item class="pa-0">
            <v-btn variant="text" class="w-100"> Disconnect</v-btn>
          </v-list-item>
        </v-list>
      </v-card-text>
    </v-card>
  </v-menu>
</template>
<script>
export default {
  name: 'UserMenu'
}
</script>