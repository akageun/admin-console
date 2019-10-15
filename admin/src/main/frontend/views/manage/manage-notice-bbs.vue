<template>
    <sui-sidebar-pushable>
        <common-sidebar/>
        <sui-sidebar-pusher :dimmed="this.$store.state.visible" @click="menuVisibleFalseStore">
            <common-header/>

            <sui-container class="main" text>

                <sui-table celled >
                    <sui-table-header>
                        <sui-table-row>
                            <sui-table-header-cell>Header</sui-table-header-cell>
                            <sui-table-header-cell>Header</sui-table-header-cell>
                            <sui-table-header-cell>Header</sui-table-header-cell>
                        </sui-table-row>
                    </sui-table-header>

                    <sui-table-body>
                        <sui-table-row>
                            <sui-table-cell>
                                <sui-label ribbon>First</sui-label>
                            </sui-table-cell>
                            <sui-table-cell>Cell</sui-table-cell>
                            <sui-table-cell>Cell</sui-table-cell>
                        </sui-table-row>
                        <sui-table-row>
                            <sui-table-cell>Cell</sui-table-cell>
                            <sui-table-cell>Cell</sui-table-cell>
                            <sui-table-cell>Cell</sui-table-cell>
                        </sui-table-row>
                        <sui-table-row>
                            <sui-table-cell>Cell</sui-table-cell>
                            <sui-table-cell>Cell</sui-table-cell>
                            <sui-table-cell>Cell</sui-table-cell>
                        </sui-table-row>
                    </sui-table-body>

                    <sui-table-footer>
                        <sui-table-row>
                            <sui-table-header-cell colspan="3">
                                <sui-menu v-sui-floated:right pagination>
                                    <a is="sui-menu-item" >
                                        <i class="angle left icon"></i>
                                    </a>
                                    <a is="sui-menu-item">1</a>
                                    <a is="sui-menu-item">2</a>
                                    <a is="sui-menu-item">3</a>
                                    <a is="sui-menu-item">4</a>
                                    <a is="sui-menu-item" >
<!--                                        <sui-icon class="angle left icon" name="]"/>-->
                                        <i class="angle right icon"></i>
                                    </a>
                                </sui-menu>
                            </sui-table-header-cell>
                        </sui-table-row>
                    </sui-table-footer>
                </sui-table>

            </sui-container>

            <common-footer/>
        </sui-sidebar-pusher>
    </sui-sidebar-pushable>
</template>

<script>
    export default {
        name: "manage-notice-bbs",
        data: () => ({
            msg: 'Welcome to Your Vue.js App'
        }),
        methods: {
            menuVisibleFalseStore() {
                this.$store.commit('menuVisible', false);
            }
        }
    }
</script>

<style scoped>

</style>
