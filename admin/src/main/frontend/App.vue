<template>
    <sui-sidebar-pushable>
        <common-sidebar/>
        <sui-sidebar-pusher :dimmed="this.$store.state.visible" @click="menuVisibleFalseStore">
            <common-header/>

            <router-view/>

            <common-footer/>
        </sui-sidebar-pusher>
    </sui-sidebar-pushable>
</template>

<script>
    import commonSidebar from "@/components/layout/common-sidebar";
    import commonFooter from "@/components/layout/common-footer";
    import commonHeader from "@/components/layout/common-header";

    export default {
        name: 'App',
        components: {commonSidebar, commonFooter, commonHeader},
        data: () => ({}),
        methods: {
            menuVisibleFalseStore() {
                this.$store.commit('menuVisible', false);
            }
        }

    }
</script>

<style>
    html, body {
        min-height: 100%;
        overflow: hidden
    }

    .main {
        margin-top: 70px;
        height: inherit;
    }


</style>
