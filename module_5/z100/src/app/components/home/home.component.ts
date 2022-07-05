import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {ApiService} from "../../services/api.service";
import {DialogComponent} from "../dialog/dialog.component";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  title = 'z100';

  displayedColumns: string[] = ['no', 'name', 'category', 'date', 'freshness', 'price', 'comment', 'action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(public dialog: MatDialog,
              private api: ApiService) {
  }

  openDialog(): void {
    this.dialog.open(DialogComponent, {
      width: '30%',
    }).afterClosed().subscribe(value => {
      if (value === 'save')
        this.getAll()
    })
  }

  getAll() {
    this.api.get().subscribe({
      next: (res) => {
        this.dataSource = new MatTableDataSource(res)
        this.dataSource.paginator = this.paginator
        this.dataSource.sort = this.sort
      }
    })
  }

  ngOnInit(): void {
    this.getAll()
  }


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  edit(row: any) {
    this.dialog.open(DialogComponent, {
      width: '30%',
      data: row
    }).afterClosed().subscribe(value => {
      if (value === 'update')
        this.getAll()
    })
  }

  delete(id: number) {
    if (confirm('are you sure?')) {
      this.api.delete(id)
        .subscribe({
          next: () => {
            this.getAll()
          },
          error: (err) => {
            console.log(err)
          }
        })
    }
  }

}
