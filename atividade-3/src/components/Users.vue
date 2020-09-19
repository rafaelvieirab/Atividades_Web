<template>
    <div>
        <h1>Users</h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>...</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in users" :key="user.id">
                    <td>{{user.id}}</td>
                    <td>{{user.name}}</td>
                    <td>{{user.email}}</td>
                    <td>...</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {
    name: 'Users',
    data: function() {
        return {
            users: [],
            baseURI: 'https://jsonplaceholder.typicode.com/users'
        }
    },
    mounted: function() {
        this.$http.get(this.baseURI)
            .then(result => this.users = result.data.slice(0,5))
            .catch(() => console.log("URI inválida"))
    }
}
</script>

<style>
    table {
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid #A0A0A0;
        border-collapse: collapse;
        padding: 5px;
    }
</style>