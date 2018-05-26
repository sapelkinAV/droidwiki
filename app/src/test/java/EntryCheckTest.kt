import com.raywenderlich.android.droidwiki.model.Entry
import org.junit.Test

import java.util.regex.Pattern
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
class EntryCheckTest{
    @Test
fun checkEntry(){
        val entry = Entry("test","test_snippet")
        assert(entry.title == "test" || entry.snippet == "test_snippet")
    }
}