/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     19-11-2014 18:58:16                          */
/*==============================================================*/

/*==============================================================*/
/* Table: COMBATE                                               */
/*==============================================================*/
create table COMBATE
(
   FECHA_COMBATE        date not null,
   GANADOR              char(50) not null,
   PERDEDOR             char(50) not null,
   ID_COMBATE           int not null,
   ID_ENTRENADOR        int not null,
   ID_LIGAPOKEMON       int,
   ENT_ID_ENTRENADOR    int not null,
   ID_TORREBATALLA      int,
   primary key (ID_COMBATE)
);

/*==============================================================*/
/* Table: ELEMENTO                                              */
/*==============================================================*/
create table ELEMENTO
(
   NOMBRE_ELEMENTO      char(50) not null,
   ID_ELEMENTO          int not null,
   primary key (ID_ELEMENTO)
);

/*==============================================================*/
/* Table: ELEMENTOS_POKEMON                                     */
/*==============================================================*/
create table ELEMENTOS_POKEMON
(
   ID_FAMILIAPOKEMON    int not null,
   ID_ELEMENTO          int not null,
   primary key (ID_FAMILIAPOKEMON, ID_ELEMENTO)
);

/*==============================================================*/
/* Table: ENTRENADOR                                            */
/*==============================================================*/
create table ENTRENADOR
(
   ID_ENTRENADOR        int not null,
   ID_MEDALLA           int,
   ID_REGION            int not null,
   NOMBRE_ENTRENADOR    char(50) not null,
   CATEGORIA_ENTRENADOR char(50) not null,
   primary key (ID_ENTRENADOR)
);

/*==============================================================*/
/* Table: EQUIPOPOKEMON                                         */
/*==============================================================*/
create table EQUIPOPOKEMON
(
   ID_FAMILIAPOKEMON    int not null,
   ID_POKEMON           int not null,
   ID_ENTRENADOR        int not null,
   primary key (ID_FAMILIAPOKEMON, ID_POKEMON, ID_ENTRENADOR)
);

/*==============================================================*/
/* Table: FAMILIA_POKEMON                                       */
/*==============================================================*/
create table FAMILIA_POKEMON
(
   ID_FAMILIAPOKEMON    int not null,
   NOMBRE_FAMILIAPOKEMON char(50) not null,
   ESPECIE_FAMILIAPOKEMON char(50),
   NUMPOKEMON_FAMILIAPOKEMON int not null,
   NIVELEVOLUCION_FAMILIAPOKEMON int,
   FORMAEVOLUCION_FAMILIAPOKEMON char(50),
   ATAQUEBASE_FAMILIAPOKEMON int not null,
   ATAQUEMAX_FAMILIAPOKEMON int not null,
   ATAQUEESPECIALBASE_FAMILIAPOKEMON int not null,
   ATAQUEESPECIALMAX_FAMILIAPOKEMON int not null,
   DEFENSABASE_FAMILIAPOKEMON int not null,
   DEFENSAMAX_FAMILIAPOKEMON int not null,
   DEFENSAESPECIALBASE_FAMILIAPOKEMON int not null,
   DEFENSAESPECIALMAX_FAMILIAPOKEMON int not null,
   VELOCIDADBASE_FAMILIAPOKEMON int not null,
   VELOCIDADMAX_FAMILIAPOKEMON int not null,
   HPBASE_FAMILIAPOKEMON int not null,
   HPMAX_FAMILIAPOKEMON int not null,
   EXPBASE              int not null,
   primary key (ID_FAMILIAPOKEMON)
);

/*==============================================================*/
/* Table: HABILIDADPOKEMON                                      */
/*==============================================================*/
create table HABILIDADPOKEMON
(
   ID_HABILIDADPOKEMON  int not null,
   NOMBRE_HABILIDADPOKEMON char(50) not null,
   DESCRIPCION_HABILIDADPOKEMON char(200) not null,
   primary key (ID_HABILIDADPOKEMON)
);

/*==============================================================*/
/* Table: HABILIDADPOKEMON_POKEMON                              */
/*==============================================================*/
create table HABILIDADPOKEMON_POKEMON
(
   ID_HABILIDADPOKEMON  int not null,
   ID_FAMILIAPOKEMON    int not null,
   ID_POKEMON           int not null,
   primary key (ID_FAMILIAPOKEMON, ID_HABILIDADPOKEMON, ID_POKEMON)
);

/*==============================================================*/
/* Table: HISTORIAL_ENTRENADOR_TORRE_BATALLA                    */
/*==============================================================*/
create table HISTORIAL_ENTRENADOR_TORRE_BATALLA
(
   ID_TORREBATALLA      int not null,
   ID_ENTRENADOR        int not null,
   CANTIDADVICTORIAS_HISTORIALENTRENADORTORREBATALLA int not null,
   CANTIDADDERROTAS_HISTORIALENTRENADORTORREBATALLA int not null,
   CANTIDADVICTORIASCONSECUTIVAS_HISTORIALENTRENADORTORREBATALLA int not null,
   primary key (ID_TORREBATALLA, ID_ENTRENADOR)
);

/*==============================================================*/
/* Table: HISTRIAL_ENTRENADOR_LIGA_POKEMON                      */
/*==============================================================*/
create table HISTRIAL_ENTRENADOR_LIGA_POKEMON
(
   ID_ENTRENADOR        int not null,
   ID_LIGAPOKEMON       int not null,
   PRIMERLUGAR          int not null,
   primary key (ID_ENTRENADOR, ID_LIGAPOKEMON)
);

/*==============================================================*/
/* Table: LIGA_POKEMON                                          */
/*==============================================================*/
create table LIGA_POKEMON
(
   REGION_LIGAPOKEMON   char(50) not null,
   ANO_LIGAPOKEMON      int not null,
   ID_LIGAPOKEMON       int not null,
   primary key (ID_LIGAPOKEMON)
);

/*==============================================================*/
/* Table: MEDALLAS                                              */
/*==============================================================*/
create table MEDALLAS
(
   ID_MEDALLA           int not null,
   ID_REGION            int not null,
   NOMBRE_MEDALLA       char(50) not null,
   CIUDAD_MEDALLA       char(50) not null,
   primary key (ID_MEDALLA)
);

/*==============================================================*/
/* Table: MOVIMIENTO                                            */
/*==============================================================*/
create table MOVIMIENTO
(
   ID_MOVIMIENTO        int not null,
   ID_ELEMENTO          int not null,
   NOMBRE_MOVIMIENTO    char(50) not null,
   POTENCIA_MOVIMIENTO  int not null,
   PRESICION_MOVIMIENTO int not null,
   PUNTOSPODER_MOVIMIENTO int not null,
   CANTIDADBLANCOS_MOVIMIENTO char(50) not null,
   CARACTERISTICA_MOVIMIENTO char(50) not null,
   CONFUNDE_MOVIMIENTO  boolean not null,
   ENVENENA_MOVIMIENTO  boolean not null,
   CONGELA_MOVIMIENTO   boolean not null,
   DUERME_MOVIMIENTO    boolean not null,
   QUEMA_MOVIMIENTO     boolean not null,
   CONTACTO_MOVIMIENTO  boolean not null,
   primary key (ID_MOVIMIENTO)
);

/*==============================================================*/
/* Table: MOVIMIENTOS_POSIBLES                                  */
/*==============================================================*/
create table MOVIMIENTOS_POSIBLES
(
   ID_MOVIMIENTO        int not null,
   ID_FAMILIAPOKEMON    int not null,
   NIVELAPRENDIZAJE     int not null,
   primary key (ID_MOVIMIENTO, ID_FAMILIAPOKEMON)
);

/*==============================================================*/
/* Table: MOVIMIENTO_APRENDIDO                                  */
/*==============================================================*/
create table MOVIMIENTO_APRENDIDO
(
   ID_MOVIMIENTO        int not null,
   ID_FAMILIAPOKEMON    int not null,
   POK_ID_FAMILIAPOKEMON int not null,
   ID_POKEMON           int not null,
   PUNTOSPODERRESTANTES_MOVIMIENTOPOKEMON int not null,
   primary key (ID_MOVIMIENTO, ID_FAMILIAPOKEMON, POK_ID_FAMILIAPOKEMON, ID_POKEMON)
);

/*==============================================================*/
/* Table: NIVEL_DE_RESISTENCIA                                  */
/*==============================================================*/
create table NIVEL_DE_RESISTENCIA
(
   ID_ELEMENTOATACA     int not null,
   ID_ELEMENTODEFIENDE  int not null,
   MULTIPLICADORDANO    float not null,
   primary key (ID_ELEMENTOATACA, ID_ELEMENTODEFIENDE)
);

/*==============================================================*/
/* Table: POKEMON                                               */
/*==============================================================*/
create table POKEMON
(
   ID_FAMILIAPOKEMON    int not null,
   ID_POKEMON           int not null,
   PSEUDONIMO_POKEMON   char(50) not null,
   NIVEL_POKEMON        int not null,
   PUNTOSSALUDTOTALES_POKEMON int not null,
   PUNTOSSALUDRESTANTES int not null,
   ATAQUE_POKEMON       int not null,
   ATAQUEESPECIAL_POKEMON int not null,
   DEFENSA_POKEMON      int not null,
   DEFENSAESPECIAL_POKEMON int not null,
   VELOCIDAD_POKEMON    int not null,
   primary key (ID_FAMILIAPOKEMON, ID_POKEMON)
);

/*==============================================================*/
/* Table: REGION                                                */
/*==============================================================*/
create table REGION
(
   ID_REGION            int not null,
   NOMBRE_REGION        char(50) not null,
   primary key (ID_REGION)
);

/*==============================================================*/
/* Table: TORRE_BATALLA                                         */
/*==============================================================*/
create table TORRE_BATALLA
(
   VERSION_TORREBATALLA char(50) not null,
   ID_TORREBATALLA      int not null,
   primary key (ID_TORREBATALLA)
);

/*==============================================================*/
/* Table: MEDALLAS_ENTRENADOR                                   */
/*==============================================================*/
create table MEDALLAS_ENTRENADOR
(
   ID_ENTRENADOR        int not null,
   ID_MEDALLA           int not null,
   primary key (ID_ENTRENADOR)
);

