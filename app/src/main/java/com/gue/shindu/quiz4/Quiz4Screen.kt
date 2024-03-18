package com.gue.shindu.quiz4

import android.content.res.Resources.Theme
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gue.shindu.quiz4.ui.Quiz4ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gue.shindu.quiz4.ui.AwalScreen
import com.gue.shindu.quiz4.ui.CVScreen
import com.gue.shindu.quiz4.ui.theme.GueQuiz4Theme

enum class Quiz4Screen(@StringRes val title: Int) {
    Awal(title = R.string.app_name),
    IsiCV(title = R.string.app_name),
    Mediator(title = R.string.app_name),
    Menikah(title = R.string.app_name)
}

@Composable
fun Quiz4App(
    navController: NavHostController = rememberNavController()
)
{
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Quiz4Screen.valueOf(
        backStackEntry?.destination?.route ?: Quiz4Screen.Awal.name
    )

    Scaffold(
        topBar = {
            Quiz4AppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateBack = { navController.navigateUp()  }
            )
        }
    ) { it ->
        //val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Quiz4Screen.Awal.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = Quiz4Screen.Awal.name) {
                AwalScreen(onNextButtonClicked = {
                    navController.navigate(Quiz4Screen.IsiCV.name)
                })
//                StartOrderScreen(
//                    quantityOptions = DataSource.quantityOptions,
//                    onNextButtonClicked = {
//                        viewModel.setQuantity(it)
//                        navController.navigate(CupcakeScreen.Flavor.name)
//                    },
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(dimensionResource(R.dimen.padding_medium))
//                )
            }
            composable(route = Quiz4Screen.IsiCV.name) {
                CVScreen(onNextButtonClicked = {})
            }
            composable(route = Quiz4Screen.Mediator.name) {
            }
            composable(route = Quiz4Screen.Menikah.name) {
//                val context = LocalContext.current
//                OrderSummaryScreen(
//                    orderUiState = uiState,
//                    onCancelButtonClicked = { cancelOrderAndNavigateToStart(viewModel, navController) },
//                    onSendButtonClicked = {
//                            subject: String, summary: String ->
//                        shareOrder(context, subject = subject, summary = summary)
//
//                    },
//                    modifier = Modifier.fillMaxHeight()
//                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Quiz4AppBar(
    currentScreen: Quiz4Screen,
    canNavigateBack: Boolean,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (currentScreen == Quiz4Screen.Awal) {
        AwalAppBar(modifier)
    }else {
        DefaultAppBar(canNavigateBack, navigateBack, modifier)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(
    canNavigateBack: Boolean,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text("TEST") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AwalAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()

            ) {
                Image(
                    painter = painterResource(R.drawable.title),
                    contentDescription = stringResource(R.string.app_name),
                    contentScale = ContentScale.None,
                )
                Text(
                    text = "v.2312–3101",
                    style =  MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        },
        modifier = modifier,

    )
}

@Preview (
    showBackground = true,
)
@Composable
fun PreviewAppBar()
{
    Quiz4AppBar(
        currentScreen = Quiz4Screen.Awal,
        navigateBack = {   },
        canNavigateBack = false
    )
}

@Preview (
    showBackground = true,
)
@Composable
fun PreviewApp()
{
    Quiz4App()
}