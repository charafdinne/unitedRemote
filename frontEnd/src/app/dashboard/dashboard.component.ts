import { Component, OnInit } from '@angular/core';
import { Shop } from '../Shop';
import { ShopService } from '../shop-service.service';
import { AppService } from "../app.service";
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  shops: Shop[];
  greeting = {};

  constructor(private shopService: ShopService, private app: AppService, private http: HttpClient) { 
    this.http.get('resource').subscribe(data => this.greeting = data);
  }

  ngOnInit() {
    this.getShops();
  }

  getShops(): void {
    this.shopService.getShops().subscribe(shops => this.shops = shops);
  }

  likeShop(id): void {

  }

  authenticated() { return this.app.authenticated; }
}
