<template>
    <div class="results">
        <h1>Posts Ímpares</h1>
        <table>
            <thead>
                <tr>
                    <th>UserId</th>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Body</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="post in posts" :key="post.id">
                    <td>{{post.userId}}</td>
                    <td>{{post.id}}</td>
                    <td>{{post.title}}</td>
                    <td>{{post.body}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {
    name: 'Posts',
    data: function() {
        return {
            posts: [],
            baseURI: 'https://jsonplaceholder.typicode.com/posts'
        }
    },
    mounted: function() {
        this.$http.get(this.baseURI)
            .then(result => {
                this.posts = result.data.filter(post => {
                    return post.id % 2
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