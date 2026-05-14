// =====================================================================
// Ejercicios 4 y 5: Formateo de resultados
// =====================================================================

/**
 * Responsable de convertir los resultados del análisis a texto para mostrar.
 */
object Formatters {

  /**
   * Formatea el análisis NER de un post individual.
   *
   * @param postTitle título del post analizado
   * @param entities  entidades detectadas en ese post
   * @return bloque de texto con el título y las entidades encontradas
   *
   * TODO (Ejercicio 4): Implementar este método.
   *
   *   Usar el método describe de cada entidad para generar la salida.
   *   No es necesario hacer match sobre el tipo concreto de cada entidad:
   *   describe ya funciona correctamente para cualquier subtipo (polimorfismo).
   *
   *   Ejemplo de salida esperada:
   *
   *     Post: "Scala 3 released at EPFL by Martin Odersky"
   *     Entidades detectadas:
   *       [ProgrammingLanguage] Scala
   *       [University] EPFL
   *       [Person] Martin Odersky
   *
   *   Si no se detectaron entidades, mostrar un mensaje indicándolo.
   */
  def formatNERResult(postTitle: String, entities: List[NamedEntity]): String = {
  // EL ENCABEZADO (Header)
  // Usamos interpolación de strings s"". 
  // Las comillas escapadas \" sirven para que el título aparezca entre comillas en el texto final.
  val header = s"Post: \"$postTitle\"\n"

  // Control de flujo.
  // Verificamos si la lista está vacía antes de procesar. 
  // Es una buena práctica para evitar que el informe quede incompleto o raro.
  if (entities.isEmpty) {
    header + "(Sin entidades detectadas)"
    } else {
        val intro = "Entidades detectadas:\n"

        // POLIMORFISMO (.map + .describe)
        // Transformamos cada OBJETO de la lista en un STRING legible.
        // e.describe: Invocamos el método de la clase base.
        // Scala detecta automáticamente si debe usar el tipo de 'Person', 'University', etc.
        // (Despacho dinámico de métodos).
       val listadoentidad = entities.map(e => "  " + e.describe)

       // .mkString("\n") toma todos los elementos de la lista y los une en una sola cadena,
       // insertando un salto de línea entre cada uno. 
       // Evita tener que usar un bucle manual y manejar el último separador.
        val listado = listadoentidad.mkString("\n")

        // CONCATENACIÓN FINAL
        // Unimos las tres piezas de texto inmutable para formar el reporte completo.
        header + intro + listado
     }
  }

  /**
   * Formatea un resumen de estadísticas de entidades por tipo.
   *
   * @param counts mapa de entityType → cantidad
   * @return texto con las estadísticas ordenadas por cantidad (de mayor a menor)
   *
   * TODO (Ejercicio 5): Implementar este método.
   *
   *   Ejemplo de salida esperada:
   *
   *     === Estadísticas de entidades ===
   *     Person: 5
   *     ProgrammingLanguage: 3
   *     Organization: 2
   *     University: 2
   */
  def formatEntityStats(counts: Map[String, Int]): String = {
    ???
  }
}
