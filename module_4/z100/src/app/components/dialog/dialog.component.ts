import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ApiService} from "../../services/api.service";
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss']
})
export class DialogComponent implements OnInit {

  gender = ['male', 'female', 'other']
  objectForm: any
  actionBtn: string = 'save';
  formName: string = 'Adding From';
  sub: any

  constructor(private formBuilder: FormBuilder, private api: ApiService,
              @Inject(MAT_DIALOG_DATA) public editData: any,
              private dialogRef: MatDialogRef<DialogComponent>
  ) {
  }

  ngOnInit(): void {
    this.api.getSub().subscribe(data => {
      this.sub = data
    })
    this.objectForm = this.formBuilder.group({
      name: ['', Validators.required],
      category: ['', Validators.required],
      date: ['', Validators.required],
      gender: ['', Validators.required],
      price: ['', Validators.required],
      comment: ['', Validators.required]
    })

    if (this.editData) {
      this.actionBtn = 'update'
      this.formName = 'Updating Form'
      this.objectForm.controls['name'].setValue(this.editData.name)
      this.objectForm.controls['category'].setValue(this.editData.category)
      this.objectForm.controls['date'].setValue(this.editData.date)
      this.objectForm.controls['gender'].setValue(this.editData.gender)
      this.objectForm.controls['price'].setValue(this.editData.price)
      this.objectForm.controls['comment'].setValue(this.editData.comment)
    }
  }

  add() {
    if (!this.editData) {
      if (this.objectForm.valid) {
        if (confirm('Are you sure?')) {
          this.api.post(this.objectForm.value)
            .subscribe({
              next: () => {
                this.objectForm.reset()
                this.dialogRef.close('save')
              },
              error: (err) => {
                console.log(err)
              }
            })
        }
      }
    } else {
      this.edit()
    }
  }


  edit() {
    if (this.objectForm.valid) {
      if (confirm('Are you sure?')) {
        this.api.put(this.objectForm.value, this.editData.id)
          .subscribe({
            next: () => {
              this.objectForm.reset()
              this.dialogRef.close('update')
            },
            error: (err) => {
              console.log(err)
            }
          })
      }
    }
  }
}
