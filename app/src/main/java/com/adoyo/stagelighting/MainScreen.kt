import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.adoyo.stagelighting.Category
import com.adoyo.stagelighting.Item
import com.adoyo.stagelighting.presentation.*

@Composable
fun MainScreen(items: List<Item>, onItemClick: (Item) -> Unit) {
    val groupedItems = items.groupBy { it.category }
    val categories = groupedItems.keys.toList()

    val tabs = categories.map {
        Tab(it.name, it.icon)
    }

    var currentTab by remember { mutableStateOf(tabs[0]) }

    Scaffold(
        topBar = { TopBar(onSearchTextChanged = {}) },
        bottomBar = {
            BottomBar(
                tabs = tabs,
                currentTab = currentTab,
                onTabSelected = { tab -> currentTab = tab }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            CategoryTabs(categories, currentTab, onCategorySelected = { category ->
                currentTab = tabs.first { it.title == category.name }
            })

            categories.forEach { category ->
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items.filter { it.category == category }.forEach { item ->
                        item {
                            ItemCard(
                                item = item,
                                modifier = Modifier.padding(end = 8.dp),
                                onItemClick = { onItemClick(item) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryTabs(
    categories: List<Category>,
    selectedCategory: Tab,
    onCategorySelected: (Category) -> Unit
) {
    val tabs = categories.map { category ->
        Tab(
            text = { Text(category.name) },
            selected = category == selectedCategory,
            onClick = { onCategorySelected(category) }
        )
    }

    TabRow(
        selectedTabIndex = selectedCategory?.let { categories.indexOf(it) } ?: 0,
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = Color.Black,
        divider = {}
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = selectedCategory?.name == categories[index].name,
                onClick = { onCategorySelected(categories[index]) },
                content = { tab.text() },
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
            )
        }
    }
}

