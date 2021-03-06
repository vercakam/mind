import QtQuick 2.4
import QtQuick.Layouts 1.12
import ".."

MenuPage {
    id: support
    title: qsTrId("support")
    property alias mlceniLink: mlceniLink
    property alias dusiLink: dusiLink
    property alias anabellLink: anabellLink
    property alias angelinyLink: angelinyLink

    GridLayout {
        anchors.fill: parent
        anchors.margins: 10
        columns: 2
        columnSpacing: parent.height * 0.1

        Image {
            Layout.fillHeight: true
            Layout.fillWidth: true
            Layout.preferredWidth: parent.width / 2
            source: "qrc:/images/dusi.svg"
            fillMode: Image.PreserveAspectFit
            MouseArea {
                id: dusiLink
                anchors.fill: parent
            }
        }

        Image {
            Layout.fillHeight: true
            Layout.fillWidth: true
            Layout.preferredWidth: parent.width / 2
            source: "qrc:/images/mlceni.svg"
            fillMode: Image.PreserveAspectFit
            MouseArea {
                id: mlceniLink
                anchors.fill: parent
            }
        }

        Image {
            Layout.fillHeight: true
            Layout.fillWidth: true
            Layout.preferredWidth: parent.width
            Layout.columnSpan: 2
            source: "qrc:/images/anabell/logo.svg"
            fillMode: Image.PreserveAspectFit
            MouseArea {
                id: anabellLink
                anchors.fill: parent
            }
        }

        Image {
            Layout.fillHeight: true
            Layout.fillWidth: true
            Layout.preferredWidth: parent.width
            Layout.columnSpan: 2
            source: "qrc:/images/angeliny.svg"
            fillMode: Image.PreserveAspectFit
            MouseArea {
                id: angelinyLink
                anchors.fill: parent
            }
        }

   }

}
