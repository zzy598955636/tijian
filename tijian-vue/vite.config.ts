import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

//导入ElementPlus相关依赖库
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
import path from "path"
import viteSvgIcons, {createSvgIconsPlugin} from 'vite-plugin-svg-icons';

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
        vue(),
        //配置按需自动加载ElementPlus控件
        AutoImport({
            resolvers: [ElementPlusResolver()]
        }),
        //引用ElementPlus控件库
        Components({
            resolvers: [ElementPlusResolver()]
        }),
        createSvgIconsPlugin({
            iconDirs: [path.resolve(process.cwd(), 'src/icons/svg')],
            symbolId: '[name]'
        })
    ],
    server: {
        host: 'localhost',
        port: 7600
    }
});

