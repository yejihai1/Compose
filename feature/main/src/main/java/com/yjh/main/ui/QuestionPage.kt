import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.yjh.main.ui.ListItem
import com.yjh.main.ui.QuestionViewModel

@Composable
fun QuestionPage(viewModel: QuestionViewModel) {
    viewModel.start()
    val state = viewModel.questionArticleListData.collectAsState(initial = mutableListOf())
    ListItem(state)
}