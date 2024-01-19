package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.Shapes

@Composable
fun HeroesList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(contentPadding = contentPadding){
        itemsIndexed(heroes){
                _, hero -> HeroItem(hero = hero, modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))
        }
    }
}
@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card (modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .sizeIn(minHeight = 72.dp)
        ){
            Column(modifier= Modifier.weight(1f)
            ){
                Text(text = stringResource(id = hero.nameRes), style = MaterialTheme.typography.displaySmall)
                Text(text = stringResource(id = hero.descriptionRes), style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier
                .size(72.dp)
                .clip(shape = Shapes.small)
            ){
                Image(
                    alignment = Alignment.TopCenter,
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
            }
        }

    }
}
@Preview
@Composable
fun HeroItemPreview() {
    val hero = Hero(R.string.hero1,R.string.description1,R.drawable.android_superhero1)
    HeroItem(hero)
}

@Preview
@Composable
fun HeroesListPreview() {
    HeroesList(heroes = HeroesRepository.heroesList)
}