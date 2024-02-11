package com.gue.quiz3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.Dimension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gue.quiz3.data.DataContoh
import com.gue.quiz3.data.Kota
import com.gue.quiz3.data.Santri
import com.gue.quiz3.ui.theme.Quiz3Theme
import com.gue.quiz3.ui.theme.UserInitial
import com.gue.quiz3.ui.theme.md_theme_light_background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Quiz3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quiz3App(
                        DataContoh().loadExampleData()
                    )
                }
            }
        }
    }
}


@Composable
fun Quiz3App(listSantri: List<Santri>, modifier: Modifier = Modifier) {

    Scaffold (
        topBar = {
            MyTopAppBar()
        },
        bottomBar = {
            MyBottomBar()
        }
    ) {
        paddingValues -> AppBody(listSantri = listSantri , paddingValue = paddingValues)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(end = dimensionResource(R.dimen.padding_12))
            ) {
                Text(
                    text = stringResource(R.string.header_title),
                    style = MaterialTheme.typography.displayMedium
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Rounded.List,
                    contentDescription = stringResource(R.string.cari_pasangan),
                )
            }
        }
    )
}


@Composable
fun MyBottomBar(modifier: Modifier = Modifier) {
    BottomAppBar(
        contentPadding = PaddingValues(horizontal = 10.dp),
        actions = {
            Row(
                modifier =Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButtonGue(icon = Icons.Filled.Home, buttonText = stringResource(R.string.button_home), enable = false )
                IconButtonGue(icon = Icons.Filled.Search, buttonText = stringResource(R.string.button_find), enable = true )
                IconButtonGue(icon = Icons.Filled.Person, buttonText = stringResource(R.string.button_profile), enable = false )

            }

        },

    )
}

@Composable
fun AppBody(listSantri: List<Santri>, paddingValue: PaddingValues) {
    Column (
        modifier = Modifier.padding(paddingValue)
    ) {
        Text(stringResource(R.string.sub_title),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_12))
            )
        LazyColumn() {
            items(listSantri) {
                ItemSantri(
                    santri = it,
                )
            }
        }
    }

}

@Composable
fun ItemSantri(
    santri: Santri,
) {
    Card(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_12))) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_12))
        ) {
            SantriInitial(santri = santri)
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_12)))
            SantriInfo(santri = santri)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = stringResource(R.string.detail),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun SantriInitial(santri: Santri, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(shape = MaterialTheme.shapes.small)
            .background(UserInitial)
            .width(dimensionResource(id = R.dimen.initial_size))
            .height(dimensionResource(id = R.dimen.initial_size)),
    ) {
        Text(
            text = santri.name.first().toString(),
            style = MaterialTheme.typography.displayMedium,
            color = Color.White
        )
    }
}

@Composable
fun SantriInfo(santri: Santri, modifier: Modifier = Modifier) {
    Column {
        Text(santri.nameAndId(), style = MaterialTheme.typography.bodyLarge)
        Text(
            "${santri.age} tahun • ${santri.kota.name}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun IconButtonGue(icon: ImageVector, buttonText: String, enable: Boolean = false) {

    Button(onClick = { /* do something */ },
        modifier = Modifier.clip(shape = RoundedCornerShape(0.dp)),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background)
    )
    {
        val btnColor = if(enable) MaterialTheme.colorScheme.surfaceTint else MaterialTheme.colorScheme.outline
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                icon,
                contentDescription = buttonText,
                tint = btnColor
            )
            Text(buttonText, style = MaterialTheme.typography.labelSmall, color = btnColor)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Quiz3Preview() {
    Quiz3Theme{
        Quiz3App(DataContoh().loadExampleData())
    }
}

@Preview(showBackground = true)
@Composable
fun Quiz3PreviewDark() {
    Quiz3Theme(
        darkTheme = true
    ){
        Quiz3App(DataContoh().loadExampleData())
    }
}