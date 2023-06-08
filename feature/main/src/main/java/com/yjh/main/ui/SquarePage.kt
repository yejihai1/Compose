import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.yjh.main.ui.ListItem
import com.yjh.main.ui.SquareViewModel

@Composable
fun SquarePage() {
    val viewModel = viewModel<SquareViewModel>()
    viewModel.start()
    val data = viewModel.getData.collectAsLazyPagingItems()
    ListItem(data)
}