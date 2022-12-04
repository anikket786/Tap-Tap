package com.twentyfourseven.home.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.twentyfourseven.designsystem.theme.AppColors
import com.twentyfourseven.designsystem.theme.WhiteTheme
import com.twentyfourseven.home.R
import com.twentyfourseven.util.AnalyticsEvent
import com.twentyfourseven.util.AnalyticsManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.twentyfourseven.designsystem.R as designR

@Composable
fun HomeScreen(
    navigateToGizmo: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreenUi(
        navigateToGizmo
    )
}

@Composable
private fun HomeScreenUi(
    navigateToGizmo: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {
    var showDialog by remember { mutableStateOf(false) }

    WhiteTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    TopAppBar(
                        title = { Text(text = stringResource(id = designR.string.app_name)) },
                        navigationIcon = {
                            IconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        scaffoldState.drawerState.open()
                                        AnalyticsManager.logEvent(AnalyticsEvent.NAV_DRAWER_CLICKED)
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Open Navigation drawer icon"
                                )
                            }
                        }
                    )
                },
                drawerContent = {
                    DrawerView()
                }
            ) { padding ->
                HomeGrid(
                    padding = padding,
                    navigateToGizmo = navigateToGizmo,
                    showComingSoonDialog = { showDialog = true }
                )

                if (showDialog) {
                    ComingSoonAlertDialog(
                        onDismissRequest = { showDialog = false }
                    )
                }
            }
        }
    }
}

@Composable
private fun HomeGrid(
    padding: PaddingValues,
    navigateToGizmo: () -> Unit,
    showComingSoonDialog: () -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(padding),
        columns = GridCells.Fixed(3)
    ) {
        item {
            HomeGridItem(
                label = stringResource(R.string.gizmo),
                color = AppColors.BgBlue,
                icon = R.drawable.ic_gizmo,
                onClick = {
                    AnalyticsManager.logEvent(AnalyticsEvent.HOME_GIZMO_CLICKED)
                    navigateToGizmo()
                }
            )
        }
        item {
            HomeGridItem(
                label = stringResource(R.string.connect),
                color = AppColors.BgGreen,
                icon = R.drawable.ic_connect,
                onClick = {
                    AnalyticsManager.logEvent(AnalyticsEvent.HOME_CONNECT_CLICKED)
                    showComingSoonDialog()
                }
            )
        }
        item {
            HomeGridItem(
                label = stringResource(R.string.dribble),
                color = AppColors.BgYellow,
                icon = R.drawable.ic_dribble,
                onClick = {
                    AnalyticsManager.logEvent(AnalyticsEvent.HOME_DRIBBLE_CLICKED)
                    showComingSoonDialog()
                }
            )
        }
    }
}

@Composable
private fun HomeGridItem(
    label: String,
    color: Color,
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .clickable { onClick() }
                .background(color = color, shape = RoundedCornerShape(8.dp))
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
            )
        }
        Text(text = label)
    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    WhiteTheme {
        HomeScreenUi({})
    }
}