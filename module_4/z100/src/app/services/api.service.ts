import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) {
  }

  get() {
    return this.http.get<any>('http://localhost:3000/list/')
  }

  post(data: any) {
    return this.http.post<any>('http://localhost:3000/list/', data)
  }

  put(data: any, id: number) {
    return this.http.put<any>('http://localhost:3000/list/' + id, data)
  }

  delete(id: number) {
    return this.http.delete<any>('http://localhost:3000/list/' + id)
  }
}
