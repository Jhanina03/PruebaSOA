<?php
 class CRUDcurso extends CRUD {
public function select($data) {
    $query = "SELECT codigo FROM cursos"; // cambia según tus nombres reales de columnas
    $statement = $this->conexion->prepare($query);
    $statement->execute($data);
    $data = $statement->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($data);
}
    public function insert(array $data)
    {
        $query = "INSERT INTO estudiante_curso(id_estudiante, id_curso) VALUES (?, ?)";
        $statement = $this->conexion->prepare($query);
        $res =  $statement->execute($data);
        return $res;
    }
     public function update(array $data, $key){}
     public function delete($key){}
}
