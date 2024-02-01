package com.gue.shindu.quiz2

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gue.shindu.quiz2.ui.theme.Purple40
import com.gue.shindu.quiz2.ui.theme.Quiz2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Quiz2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainDisplay()
                }
            }
        }
    }
}

@Composable
fun MainDisplay() {
    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(20.dp))
            PartLogo()
            Spacer(Modifier.height(40.dp))
            PartLogin()
            Spacer(Modifier.height(40.dp))
            PartHelp()
        }
        BottomPart()
    }

}

@Composable
fun PartLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = stringResource(R.string.logo_desc),
        contentScale = ContentScale.FillWidth,
        modifier = modifier
            .padding(horizontal = 120.dp, vertical = 7.dp)
    )
}

@Composable
fun PartLogin(modifier: Modifier = Modifier) {
    val nipState = remember {
        mutableStateOf("")
    }
    val passwordState = remember {
        mutableStateOf("")
    }

    val ctx = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.nip),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditField(
            value = nipState.value ,
            onValueChanged = {nipState.value = it} ,
            keyboardOptions =  KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Characters,
                imeAction = ImeAction.Next),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.password),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditField(
            value = passwordState.value ,
            onValueChanged = { passwordState.value = it } ,
            keyboardOptions =  KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(35.dp))
        Button(
            onClick = {
                Toast.makeText(
                    ctx,
                    cekLogin(
                        nipState.value,
                        passwordState.value,
                        ctx
                    ),
                    Toast.LENGTH_LONG
                ).show()
                 },
            shape =  RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
            ) {
            Text(
                style =  MaterialTheme.typography.labelSmall,
                text = stringResource(R.string.login)
            )

        }

    }
}

private fun cekLogin(nip: String, pwd: String, context: Context): String {
    var msg : String
    if (nip.isEmpty() && pwd.isEmpty()) msg = context.getString(R.string.nip_pwd_failed)
    else if (nip.isEmpty()) msg = context.getString(R.string.nip_fail)
    else if (pwd.isEmpty()) msg = context.getString(R.string.pwd_fail)
    else if (nip.startsWith("AR"))
        msg = context.getString(R.string.menuju_halaman_beranda)
    else
        msg = context.getString(R.string.format_nip_arn_art)
    return msg

}

@Composable
fun PartHelp () {
    val ctx = LocalContext.current

    var hubCSIkhwan = stringResource(R.string.menghubungi_cs_ikhwan)
    var hubCSAkhwat = stringResource(R.string.menghubungi_cs_akhwat)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(R.string.belum_bisa_akses),
            style = MaterialTheme.typography.labelSmall,
        )
        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(
            text = AnnotatedString(stringResource(R.string.hubungi_cs_ikhwan)),
            onClick = {
                Toast.makeText(
                    ctx,
                    hubCSIkhwan,
                    Toast.LENGTH_LONG
                ).show()
            },
            style = MaterialTheme.typography.labelSmall.copy(color = Color.Blue)
        )
        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(
            text = AnnotatedString(stringResource(R.string.hubungi_cs_akhwat)),
            onClick = {
                Toast.makeText(
                    ctx,
                    hubCSAkhwat,
                    Toast.LENGTH_LONG
                ).show()
            },
            style = MaterialTheme.typography.labelSmall.copy(color = Color.Blue)
        )

    }
}

@Composable
fun EditField(
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    label: String = "",
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        singleLine = true,
        onValueChange = onValueChanged,
        label ={ Text( label ) },
        keyboardOptions = keyboardOptions,
        visualTransformation = if (keyboardOptions.keyboardType == KeyboardType.Password)
            PasswordVisualTransformation() else
            VisualTransformation.None,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp)),
    )
}

@Composable
fun FAQField() {
    val ctx = LocalContext.current
    var faq = stringResource(R.string.ke_halaman_faq)
    Button(
        onClick = {
            Toast.makeText(
                ctx,
                faq,
                Toast.LENGTH_LONG
            ).show()
        },
        shape =  RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color.Blue),
        modifier = Modifier

            .fillMaxWidth()
            .height(52.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            style =  MaterialTheme.typography.labelSmall.copy(color= Color.Blue),
            text = stringResource(R.string.lihat_faq)

        )

    }
}

@Composable
fun BottomPart() {
     FAQField()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Quiz2Theme {
        MainDisplay()
    }
}