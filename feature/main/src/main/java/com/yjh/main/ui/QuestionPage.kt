import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.paging.compose.collectAsLazyPagingItems
import com.yjh.main.ui.ListItem
import com.yjh.main.ui.QuestionViewModel

@Composable
fun QuestionPage(viewModel: QuestionViewModel) {
    viewModel.start()
    val data = viewModel.getData.collectAsLazyPagingItems()
    ListItem(data)
}