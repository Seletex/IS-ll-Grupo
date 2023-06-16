import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { DocumentosService } from './services/documentos/documentos.service';
import { GimnasioServise } from './services/gimnasios/gimnasios.service';
import { EntrenadorService } from './services/entrenador/entrenador.service';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {
  title(title: any) {
    throw new Error('Method not implemented.');
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  personaForm: FormGroup;
  paises: any;
  estados: any;
  personas: any;
  dataSource: MatTableDataSource<any>;

  displayedColumns: string[] = ['id', 'identificacion', 'nombre', 'apellido', 'salario', 'gimnasio','documento','options'];

  panelOpenState = false;

  constructor(
    public fb: FormBuilder,
    public documentosService: DocumentosService,
    public gimnasioService: GimnasioServise,
    public entrenadorService: EntrenadorService
  ) {}

  ngAfterViewInit(): void {
    this.setDataAndPagination();
  }

  ngOnInit(): void {
    this.personaForm = this.fb.group({
      id: [''],
      identificacion: ['', Validators.required],
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      salario: ['', Validators.required],
      gimnasio: ['', Validators.required],
      documento: ['', Validators.required],
    });

    this.gimnasioService.getAllPaises().subscribe(resp => {
      this.paises = resp;
    },
    error => {
      console.error(error);
    });

    this.documentosService.getAllPaises().subscribe(resp => {
      this.paises = resp;
    },
    error => {
      console.error(error);
    });

    this.entrenadorService.getAllPersonas().subscribe(resp => {
      this.personas = resp;
      this.setDataAndPagination();
    },
    error => {
      console.error(error);
    });
  }

  guardar(): void {
    this.entrenadorService.savePersona(this.personaForm.value).subscribe(resp => {
      this.personaForm.reset();
      this.personaForm.setErrors(null);
      this.personas = this.personas.filter(persona => resp.id !== persona.id);
      this.personas.push(resp);
      this.setDataAndPagination();
    },
    error => {
      console.error(error);
    });
  }

  eliminar(persona): void {
    this.entrenadorService.deletePersona(persona.id).subscribe(resp => {
      if (resp) {
        this.personas = this.personas.filter(p => p.id !== persona.id);
        this.setDataAndPagination();
      }
    });
  }

  editar(persona): void {
    this.personaForm.setValue({
      id: persona.id,
      nombre: persona.nombre,
      apellido: persona.apellido,
      edad: persona.edad,
      pais: persona.pais,
      estado: persona.estado,
    });
    this.panelOpenState = !this.panelOpenState;
  }

  setDataAndPagination(): void {
    this.dataSource = new MatTableDataSource(this.personas);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
}
