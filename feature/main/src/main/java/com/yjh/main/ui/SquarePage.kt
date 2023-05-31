import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.yjh.main.ui.ListItem
import com.yjh.main.ui.SquareViewModel

@Composable
fun SquarePage(viewModel: SquareViewModel) {
    viewModel.start()
    val state = viewModel.squareArticleListData.collectAsState(initial = mutableListOf())
    ListItem(state)
}