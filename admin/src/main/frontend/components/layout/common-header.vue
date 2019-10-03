<template>
    <sui-menu fixed inverted>
        <sui-container fluid>
            <a is="sui-menu-item" @click.stop="menuVisibleTrueStore">Menu</a>

            <a href="#" is="sui-menu-item" class="header">
                Admin Console
            </a>

            <a is="sui-menu-item" href="#">Home</a>

            <sui-dropdown text="Dropdown" item class="simple">
                <sui-dropdown-menu>
                    <a is="sui-dropdown-item" href="#">Link Item</a>
                    <a is="sui-dropdown-item" href="#">Link Item</a>

                    <sui-dropdown-divider/>
                    <sui-dropdown-header>Header Item</sui-dropdown-header>

                    <sui-dropdown-item>
                        <sui-icon name="dropdown"/>
                        Submenu

                        <sui-dropdown-menu class="simple">
                            <a is="sui-dropdown-item" href="#">Link Item</a>
                            <a is="sui-dropdown-item" href="#">Link Item</a>
                        </sui-dropdown-menu>
                    </sui-dropdown-item>

                    <a is="sui-dropdown-item" href="#">Link Item</a>
                </sui-dropdown-menu>
            </sui-dropdown>
        </sui-container>
    </sui-menu>
</template>

<script>
    export default {
        name: "common-header",
        data: () => ({}),
        methods: {
            menuVisibleTrueStore() {
                this.$store.commit('menuVisible', true);
            }
        }
    }
</script>

<style scoped>

</style>
