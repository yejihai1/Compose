import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.paging.compose.collectAsLazyPagingItems
import com.yjh.main.ui.ListItem
import com.yjh.main.ui.SquareViewModel

@Composable
fun SquarePage(viewModel: SquareViewModel) {
    viewModel.start()
    val data = viewModel.getData.collectAsLazyPagingItems()
    ListItem(data)
}