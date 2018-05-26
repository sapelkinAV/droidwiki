import com.raywenderlich.android.droidwiki.utils.Const
import org.junit.Test


class CheckBaseUrlTest{



    @Test
fun checkURL(){
        assert("${Const.PROTOCOL}://${Const.LANGUAGE}.${Const.BASE_URL}" == "https://en.wikipedia.org/w/api.php")
    }
}