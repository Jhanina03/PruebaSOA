<?php
class CRUDestudiante extends CRUD
{
    public function select($data)
    {
        $query = "SELECT * FROM estudiantes";
        $statement = $this->conexion->prepare($query);
        $statement->execute($data);
        $data = $statement->fetchAll(PDO::FETCH_ASSOC);
        $data = json_encode($data);
        return $data;
    }

    public function selectOne($cedula)
    {
        if ($cedula == null || $cedula == '') {
            return false;
        }
        $query = "SELECT * FROM estudiantes WHERE cedula=?";
        $statement = $this->conexion->prepare($query);
        $statement->execute($cedula);
        $data = $statement->fetchAll(PDO::FETCH_ASSOC);
        $data = $data[0];
        $data = json_encode($data);
        return $data;
    }

    public function insert(array $data)
    {
        $query = "INSERT INTO estudiantes VALUES (?, ?, ?, ?, ?)";
        if (count($data) != 5) {
            return false;
        }
        $statement = $this->conexion->prepare($query);
        $res =  $statement->execute($data);
        return $res;
    }
    public function update(array $data, $cedula)
    {
        if (count($data) > 4 || $cedula == null || $cedula == '') {
            return false;
        }
        $query = "UPDATE estudiantes SET nombre=?, apellido=?, direccion=?, telefono=? WHERE cedula=?";
        $statement = $this->conexion->prepare($query);
        array_push($data, $cedula);
        return $statement->execute($data);
    }
    public function delete($cedula)
    {
        if ($cedula == null || $cedula == '') {
            return false;
        }
        $query = "DELETE FROM estudiantes WHERE cedula=?";
        $statement = $this->conexion->prepare($query);
        return $statement->execute([$cedula]);
    }
}
