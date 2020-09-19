<template>
    <div class="results">
        <h1>Todos do Usuário 2 que já foram completados</h1>
        <table>
            <thead>
                <tr>
                    <th>UserId</th>
                    <th>id</th>
                    <th>title</th>
                    <th>completed</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(todo,index) in todos" :key="index">
                    <td>{{todo.userId}}</td>
                    <td>{{todo.id}}</td>
                    <td>{{todo.title}}</td>
                    <td>{{todo.completed}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {
    name: 'Todos',
    data: function() {
        return {
            todos: [],
            baseURI: 'https://jsonplaceholder.typicode.com/todos'
        }
    },
    mounted: function() {
        this.$http.get(this.baseURI)
            .then(result => {
                this.todos = result.data.filter(todo => {
                    return todo.userId == 2 && todo.completed
                })
            }).catch(() => console.log("Ocorreu um problema"))
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