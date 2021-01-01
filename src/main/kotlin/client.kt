import com.ccfraser.muirwik.components.mThemeProvider
import com.ccfraser.muirwik.components.styles.mStylesProvider
import react.dom.render
import kotlinx.browser.document
import components.App
import react.RBuilder

@JsModule("react-hot-loader")
@JsNonModule
private external val hotModule: dynamic
private val hot = hotModule.hot
private val module = js("module")

fun main() {
    val hotWrapper = hot(module)
    render(document.getElementById("root")) {
        mStylesProvider("jss-insertion-point") {
            mThemeProvider {
                hotWrapper(app())
            }
        }
    }
}
fun RBuilder.app() = child(App::class) {}