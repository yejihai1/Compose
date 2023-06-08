import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.yjh.main.ui.ListItem
import com.yjh.main.ui.QuestionViewModel

@Composable
fun QuestionPage() {
    val viewModel = viewModel<QuestionViewModel>()
    viewModel.start()
    val data = viewModel.getData.collectAsLazyPagingItems()
    ListItem(data)
}