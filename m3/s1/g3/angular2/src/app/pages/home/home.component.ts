import { Component } from '@angular/core';
import { Articolo } from '../../Models/articolo';
import { ArticoliService } from '../../articoli.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  articoliArray: Articolo[] = [];
  articoliRandom: Articolo[] = [];

  constructor(private articoliSvc: ArticoliService) {}

  ngOnInit() {
    // fetch('../assets/db.json')
    //   .then((articoli) => articoli.json())
    //   .then((articolo) => {
    //     this.articoliArray = articolo.posts;
    //     this.soloQuattroRandom();
    //   });

    this.articoliSvc.getArticoli().then((res) => {
      // this.articoliRandom = res;
      // console.log(this.articoliRandom);
      for (let i = 0; i < 4; i++) {
        let random = Math.floor(Math.random() * this.articoliArray.length);
        this.articoliRandom.push(res[random]);
        // per non ripetere stesso articolo
        this.articoliArray = res.filter(
          (articolo) => articolo !== this.articoliArray[random]
        );
      }
    });
    console.log(this.articoliArray);
  }

  // soloQuattroRandom(): void {
  //   for (let i = 0; i < 4; i++) {
  //     let random = Math.floor(Math.random() * this.articoliArray.length);
  //     this.articoliRandom.push(this.articoliArray[random]);
  //     //per non ripetere stesso articolo
  //     this.articoliArray = this.articoliArray.filter(
  //       (articolo) => articolo !== this.articoliArray[random]
  //     );
  //   }
  // }
}
