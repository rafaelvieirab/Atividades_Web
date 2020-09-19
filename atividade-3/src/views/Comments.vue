<template>
    <div class="results">
        <h1>Comentários Pares</h1>
        <table>
            <thead>
                <tr>
                    <th>PostId</th>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Body</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="comment in comments" :key="comment.id">
                    <td>{{comment.postId}}</td>
                    <td>{{comment.id}}</td>
                    <td>{{comment.name}}</td>
                    <td>{{comment.email}}</td>
                    <td>{{comment.body}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {
    name: 'Comments',
    data: function() {
        return {
            comments: [],
            baseURI: 'https://jsonplaceholder.typicode.com/comments'
        }
    },
    mounted: function() {
        this.$http.get(this.baseURI)
            .then(result => {
                this.comments = result.data.filter(comment => {
                    return !(comment.id % 2)
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