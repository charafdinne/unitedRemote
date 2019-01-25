import { Component, OnInit } from '@angular/core';
import { Shop } from '../Shop';
import { ShopService } from "../shop-service.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  shops: Shop[];

  constructor(private shopService: ShopService) { }

  ngOnInit() {
    this.getShops();
  }

  getShops(): void {
    this.shopService.getShops().subscribe(shops => this.shops = shops);
  }

}
