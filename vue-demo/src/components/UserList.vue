<template>
  <div>
    <h1>User List</h1>
    <ul v-if="users.length">
      <li v-for="user in users" :key="user.id">
        {{ user.name }} - {{ user.email }}
      </li>
    </ul>
    <p v-else>Loading users...</p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      users: [],
    };
  },
  created() {
    axios
      .get("http://localhost:8081/users")
      .then((response) => {
        this.users = response.data;
      })
      .catch((error) => {
        console.error("Error fetching users:", error);
      });
  },
};
</script>

<style scoped>
h1 {
  color: #333;
}
</style>
