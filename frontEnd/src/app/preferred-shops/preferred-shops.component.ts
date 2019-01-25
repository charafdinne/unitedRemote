import { Component, OnInit } from '@angular/core';
import {Shop} from '../Shop';
import {ShopService} from '../shop-service.service';

@Component({
  selector: 'app-preferred-shops',
  templateUrl: './preferred-shops.component.html',
  styleUrls: ['./preferred-shops.component.css']
})
export class PreferredShopsComponent implements OnInit {

  shops: Shop[];

  constructor(private shopService: ShopService) { }

  ngOnInit() {
  }

  getShops(): void {
    
  }
}
