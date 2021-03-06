// Generated by https://quicktype.io

export interface PostResponse {
    id:          number;
    titulo:      string;
    descripcion: string;
    imagen:      string;
    isPublic:    boolean;
    user:        User;
}

export interface User {
    id:                    string;
    nombre:                string;
    nick:                  string;
    apellidos:             string;
    direccion:             string;
    email:                 string;
    telefono:              string;
    avatar:                string;
    fechNaci:              string;
    password:              string;
    rol:                   string;
    isPublic:              boolean;
    enabled:               boolean;
    authorities:           Authority[];
    username:              string;
    credentialsNonExpired: boolean;
    accountNonExpired:     boolean;
    accountNonLocked:      boolean;
}

export interface Authority {
    authority: string;
}
